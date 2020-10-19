package antivariant.qa.androidtesting;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static androidx.test.uiautomator.By.pkg;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SmokeTest {

    private UiDevice mDevice; //Android Device
    private final String TESTING_PACKAGE_NAME = "com.ub.sushimaster.ukraine";
    private final int TIMEOUT=10000;
    private final String TAKE_MYSELF_BUTTON_ID = "com.ub.sushimaster.ukraine:id/btn_select_address_i_take_it_myself";

//    @Test
//    public void checkPreconditions() {
//        assertThat(mDevice, CoreMatchers.notNullValue());
//    }


    @Test
    public void startupScreenTakeItMyself(){
        mDevice.wait(Until.hasObject(By.res(TAKE_MYSELF_BUTTON_ID)),TIMEOUT);
        UiObject2 btn = mDevice.findObject(By.res(TAKE_MYSELF_BUTTON_ID));
        btn.click();

    }



    @Before
    public void SetUp() {

        TestFunctions tf = new TestFunctions();
        mDevice = tf.LaunchApp(TESTING_PACKAGE_NAME);
        mDevice.waitForWindowUpdate(TESTING_PACKAGE_NAME,5000);
    }

}



