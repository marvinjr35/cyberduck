package ch.cyberduck.core.local;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class WorkspaceBrowserLauncherTest {

    @Test
    public void testOpen() {
        assertFalse(new WorkspaceBrowserLauncher().open(""));
        assertFalse(new WorkspaceBrowserLauncher().open(null));
    }
}
