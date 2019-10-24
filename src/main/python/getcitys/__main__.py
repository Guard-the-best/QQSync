import urllib
import urllib.error
import urllib.request
from bs4 import BeautifulSoup
import re


def static_vars(**kwargs):
    def decorate(func):
        for k in kwargs:
            setattr(func, k, kwargs[k])
        return func

    return decorate


class Spider:
    request = urllib.request

    def __init__(self):
        self.request = urllib.request

    def get_html(self, url_to):
        get = False
        while get is False:
            try:
                page = self.request.urlopen(url_to)
                get = True
            except urllib.error.HTTPError as e:
                get = False
        html = page.read().decode('GB18030')
        return str(html)


@static_vars(nextid=0)
class Data:
    id = 0
    parent_id = 0
    name = ""
    level = 0

    def __init__(self, parent_id: int, name: str, level: int):
        Data.nextid += 1
        self.id = Data.nextid
        self.parent_id = parent_id
        self.name = name
        self.level = level

    def __str__(self):
        return "(" + str(self.id) + "," + str(self.parent_id) + ",'" + str(self.name) + "'," + str(self.level) + ')'


# get province list
spider = Spider()
data = {}
f = open("../resources/citys.dat", "w", encoding="GB18030")
country_page = 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/index.html'
country_page_html = spider.get_html(country_page)

# get province
patten = "<a href='(.*?)'>(.*?)<br/></a>"
provinces = []
while re.search(patten, country_page_html) is not None:
    match = re.search(patten, country_page_html)
    provinces.append((match.group(1), match.group(2)))
    addon = Data(0, match.group(2), 1)
    f.write(str(addon) + ',\n')
    f.flush()
    data.update({match.group(2): addon})
    country_page_html = country_page_html[match.start() + 1:]

# get city
patten = '<a href="(.*?)">(.*?)</a>'
for province_part_page, province_name in provinces:
    print(province_name)
    parentid = data[province_name].id
    citys = []
    province_page = urllib.parse.urljoin(country_page, './' + province_part_page)
    soup = BeautifulSoup(spider.get_html(province_page), features="html.parser")
    table = str(soup.find('table', class_='citytable'))
    while re.search(patten, table) is not None:
        match = re.search(patten, table)
        table = table[match.start() + 1:]
        match = re.search(patten, table)
        citys.append((match.group(1), match.group(2)))
        addon = Data(parentid, match.group(2), 2)
        f.write(str(addon) + ',\n')
        f.flush()
        data.update({match.group(2): addon})
        table = table[match.start() + 1:]

    # get county
    for city_part_page, city_name in citys:
        parentid = data[city_name].id
        print(city_name)
        counties = []
        city_page = urllib.parse.urljoin(province_page, './' + city_part_page)
        soup = BeautifulSoup(spider.get_html(city_page), features="html.parser")
        table = str(soup.find('table', class_='countytable'))
        while re.search(patten, table) is not None:
            match = re.search(patten, table)
            table = table[match.start() + 1:]
            match = re.search(patten, table)
            counties.append((match.group(1), match.group(2)))
            addon = Data(parentid, match.group(2), 3)
            data.update({match.group(2): addon})
            f.write(str(addon) + ',\n')
            f.flush()
            table = table[match.start() + 1:]

        # get town
        for county_part_page, county_name in counties:
            parentid = data[county_name].id
            # print(county_name)
            town = []
            county_page = urllib.parse.urljoin(city_page, './' + county_part_page)
            soup = BeautifulSoup(spider.get_html(county_page), features="html.parser")
            table = str(soup.find('table', class_='towntable'))
            while re.search(patten, table) is not None:
                match = re.search(patten, table)
                table = table[match.start() + 1:]
                match = re.search(patten, table)
                town.append((match.group(1), match.group(2)))
                addon = Data(parentid, match.group(2), 4)
                data.update({match.group(2): addon})
                f.write(str(addon) + ',\n')
                f.flush()
                table = table[match.start() + 1:]
            # for town_part_page, town_name in town:
            #     parentid = data[town_name].id
            #     # print(town_name)
            #     town_page = urllib.parse.urljoin(county_page, './' + town_part_page)
            #     soup = BeautifulSoup(spider.get_html(town_page), features="html.parser")
            #     table = soup.find('table', class_='villagetable')
            #     trs = table.find_all('tr', class_='villagetr')
            #     for tr in trs:
            #         tds =tr.find_all('td')
            #         vi = tds[2].string
            #         addon = Data(parentid, vi, 5)
            #         data.update({vi: addon})
            #         f.write(str(addon) + '\n')
            #         f.flush()
f.close()
