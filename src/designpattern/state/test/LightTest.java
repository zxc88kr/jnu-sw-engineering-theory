package designpattern.state.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import designpattern.state.Light;
import designpattern.state.OFF;
import designpattern.state.ON;

public class LightTest {
	Light light;

	@Before
	public void setUp() {
		light = new Light();
	}

	@Test
	public void 온오프() {
		light.on_button();
		light.off_button();
		assertTrue(light.getState() instanceof OFF);
	}

	@Test
	public void 온온오프() {
		light.on_button();
		light.on_button();
		light.off_button();
		assertTrue(light.getState() instanceof OFF);
	}

	@Test
	public void 온온온() {
		light.on_button();
		light.on_button();
		light.on_button();
		assertTrue(light.getState() instanceof ON);
	}

	@After
	public void cleanUp() {
		light = null;
	}
}