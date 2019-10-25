package dao;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import model.*;
import org.junit.*;
import util.CassandraDB;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PhoneDaoTest {

    private static Session session;
    private static Phone testPhone = new Phone() {{
        setUuid(UUID.fromString("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
        setPhoneId("999");
        setBrand("TEST_BRAND");
        setName("TEST_NAME");
        setPrice(Arrays.asList(99999, 99999));
        setColor(Arrays.asList("Matte Black", "Gloss Black"));
        setImage("image_url");
        setLaunch(new Launch() {{
            setAnnounced(LocalDate.fromYearMonthDay(2200, 1, 1));
            setReleased(LocalDate.fromYearMonthDay(2200, 1, 1));
            setStatus("Unreleased");
        }});
        setBody(new Body() {{
            setDimensions("200 x 100 x 10 mm");
            setWeight("200 g");
            setBuild("No glass");
            setSim("None");
            setOther(Arrays.asList("Nothing", "Nothing"));
        }});
        setDisplay(new Display() {{
            setType("amoled+");
            setSize("10 inches");
            setResolution("7680 × 4320 pixels");
            setProtection("No glass");
            setOther(Arrays.asList("Nothing", "Nothing"));
        }});
        setPlatform(new Platform() {{
            setOs("Android 20.0");
            setChipset("Qualcomm Snapdragon 2000+");
            setCpu("Deca-core");
            setGpu("GeForce RTX 2080");
        }});
        setMemory(new Memory() {{
            setCardSlot("Yes");
            setInternal(Arrays.asList("500GB 256GB RAM", "1TB 512GB RAM"));
            setOther(Arrays.asList("Nothing", "Nothing"));
        }});
        setMainCamera(new MainCamera() {{
            setCamera(Arrays.asList("100 MP", "110MP"));
            setFeature(Arrays.asList("Nothing", "Nothing"));
            setVideo(Arrays.asList("Nothing", "Nothing"));
        }});
        setSelfieCamera(new SelfieCamera() {{
            setCamera(Arrays.asList("200 MP", "210MP"));
            setFeature(Arrays.asList("Nothing", "Nothing"));
            setVideo(Arrays.asList("Nothing", "Nothing"));
        }});
        setSound(new Sound() {{
            setLoudspeaker("Yes");
            setHeadphoneJack(Boolean.TRUE);
            setOther(Arrays.asList("Nothing", "Nothing"));
        }});
        setComms(new Comms() {{
            setWlan("Wi-Fi 10");
            setBluetooth("10.0");
            setGps("Yes");
            setNfc(Boolean.TRUE);
            setRadio("FM Radio");
            setUsb("10.0");
        }});
        setFeatures(new Features() {{
            setSensor(Arrays.asList("Ultrasound", "X-ray"));
            setOther(Arrays.asList("Nothing", "Nothing"));
        }});
        setBattery(new Battery() {{
            setBattery("10000 mAh battery");
            setCharging(Arrays.asList("Nothing", "Nothing"));
        }});
    }};

    @BeforeClass
    public static void dbSetup() {
        session = CassandraDB.connect();
    }

    @AfterClass
    public static void dbShutdown() {
        CassandraDB.shutdown();
    }

    @Before
    public void setupData() {
        new MappingManager(session).mapper(Phone.class).save(testPhone);
    }

    @After
    public void clearData() {
        new MappingManager(session).mapper(Phone.class).delete(testPhone.getUuid(), testPhone.getPhoneId());
    }

    @Test
    public void createPhoneInDB() {
        PhoneDao phoneDao = new PhoneDao();
        phoneDao.create(testPhone);

        Mapper<Phone> phoneMapper = new MappingManager(session).mapper(Phone.class);
        ResultSet resultSet = session.execute(String.format("SELECT * FROM phone_webapp.phone WHERE uuid=%s", testPhone.getUuid()));
        Phone dbPhone = phoneMapper.map(resultSet).one();

        Assert.assertNotNull(testPhone);
        Assert.assertNotNull(dbPhone);
        Assert.assertEquals(testPhone.toString(), dbPhone.toString());
    }

    @Test
    public void retrievePhoneFromDB() {
        PhoneDao phoneDao = new PhoneDao();
        Phone dbPhone = phoneDao.get(testPhone.getUuid());

        Assert.assertNotNull(testPhone);
        Assert.assertNotNull(dbPhone);
        Assert.assertEquals(testPhone.toString(), dbPhone.toString());
    }

    @Test
    public void retrieveAllPhoneFromDB() {
        PhoneDao phoneDao = new PhoneDao();
        List<Phone> phoneList = phoneDao.getAll();

        Mapper<Phone> phoneMapper = new MappingManager(session).mapper(Phone.class);
        ResultSet resultSet = session.execute("SELECT * FROM phone_webapp.phone");
        List<Phone> dbPhoneList = phoneMapper.map(resultSet).all();

        Assert.assertNotNull(dbPhoneList);
        Assert.assertNotNull(phoneList);
        Assert.assertTrue(dbPhoneList.size() > 0);
        Assert.assertTrue(phoneList.size() > 0);
        Assert.assertEquals(dbPhoneList.size(), phoneList.size());
        Assert.assertEquals(dbPhoneList.toString(), phoneList.toString());
    }

    @Test
    public void updatePhoneInDB() {
        String updateBrand = "X_TEST_BRAND_X";
        String updateName = "X_TEST_NAME_X";
        testPhone.setBrand(updateBrand);
        testPhone.setName(updateName);

        PhoneDao phoneDao = new PhoneDao();
        phoneDao.update(testPhone);

        Mapper<Phone> phoneMapper = new MappingManager(session).mapper(Phone.class);
        ResultSet resultSet = session.execute(String.format("SELECT * FROM phone_webapp.phone WHERE uuid=%s", testPhone.getUuid()));
        Phone dbPhone = phoneMapper.map(resultSet).one();

        Assert.assertNotNull(testPhone);
        Assert.assertNotNull(dbPhone);
        Assert.assertEquals(updateBrand, dbPhone.getBrand());
        Assert.assertEquals(updateName, dbPhone.getName());
        Assert.assertEquals(testPhone.toString(), dbPhone.toString());
    }

    @Test
    public void deletePhoneInDB() {
        PhoneDao phoneDao = new PhoneDao();
        phoneDao.delete(testPhone);

        Mapper<Phone> phoneMapper = new MappingManager(session).mapper(Phone.class);
        ResultSet resultSet = session.execute(String.format("SELECT * FROM phone_webapp.phone WHERE uuid=%s", testPhone.getUuid()));
        Phone dbPhone = phoneMapper.map(resultSet).one();

        Assert.assertNotNull(testPhone);
        Assert.assertNull(dbPhone);
    }

}
