package cn.edu.csu.dyp.dao.util;

import cn.edu.csu.dyp.dao.userDao.IsUserExistDao;
import cn.edu.csu.dyp.dao.userDao.RegisterDao;
import cn.edu.csu.dyp.model.User;
import cn.edu.csu.dyp.service.UserService;
import org.junit.Assert;
import org.junit.Test;

public class TestDataBaseDao {
    @Test
    public void testRegister() {
        try(DataBaseDao<Boolean> dataBaseDao = new DataBaseDao<>()) {
            Assert.assertTrue(dataBaseDao.query(new RegisterDao(new User(null,"test","123456",null,"Jack"))));
        }
    }

    @Test
    public void testExist() {
        try(DataBaseDao<Boolean> dataBaseDao = new DataBaseDao<>()) {
            Assert.assertTrue(dataBaseDao.query(new IsUserExistDao("admin")));
            Assert.assertFalse(dataBaseDao.query(new IsUserExistDao("tst")));
        }
    }
}