package ArcanaFramework.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import ArcanaFramework.helpers.StartupHelper;

public class ArcanaLauncher {
    private ApplicationListener application;
    private final Lwjgl3ApplicationConfiguration configuration;

    Launcher(ApplicationListener application, Lwjgl3ApplicationConfiguration configuration) {
        this.application = application;
        this.configuration = configuration;

        Gdx.graphics.setContinuousRendering(false);
    }

    Launcher(ApplicationListener application) {
        this(application, getDefaultConfiguration());
    }

    Lwjgl3Application createApplication() {
        if (StartupHelper.startNewJvmIfRequired()) return null; // This handles macOS support and helps on Windows.

        return new Lwjgl3Application(this.application, configuration);
    }
    
    //// This is the configuration for the application.
    static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("ArcanaFramewok");

        //// Vsync limits the frames per second to what your hardware can display, and helps eliminate
        //// screen tearing. This setting doesn't always work on Linux, so the line after is a safeguard.
        configuration.useVsync(true);

        //// Limits FPS to the refresh rate of the currently active monitor, plus 1 to try to match fractional
        //// refresh rates. The Vsync setting above should limit the actual FPS to match the monitor.
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);

        //// If you remove the above line and set Vsync to false, you can get unlimited FPS, which can be
        //// useful for testing performance, but can also be very stressful to some hardware.
        //// You may also need to configure GPU drivers to fully disable Vsync; this can cause screen tearing.
        configuration.setWindowedMode(640, 480);

        //// You can change these files; they are in src/main/resources/.
        //// The files are in the root of the project.
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
        return configuration;
    }
}