package ch.cyberduck.core.editor;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.AbstractTestCase;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.NullSession;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.local.Application;
import ch.cyberduck.ui.action.Worker;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @version $Id:$
 */
public class AbstractEditorTest extends AbstractTestCase {

    private class DisabledEditor extends AbstractEditor {
        public DisabledEditor(final Application application, final Session session, final Path file) {
            super(application, session, file);
        }

        @Override
        protected void open(final Worker background) {
            //
        }

        @Override
        protected void save(final Worker background) {
            //
        }

        @Override
        protected void edit() throws IOException {
            //
        }
    }

    @Test
    public void testEquals() throws Exception {
        final NullSession session = new NullSession(new Host("h"));
        assertEquals(
                new DisabledEditor(new Application("i"), session, new Path("/p/f", Path.FILE_TYPE)),
                new DisabledEditor(new Application("i"), session, new Path("/p/f", Path.FILE_TYPE))
        );
        assertNotEquals(
                new DisabledEditor(new Application("i"), session, new Path("/p/f", Path.FILE_TYPE)),
                new DisabledEditor(new Application("i"), session, new Path("/p/g", Path.FILE_TYPE))
        );
        assertNotEquals(
                new DisabledEditor(new Application("a"), session, new Path("/p/f", Path.FILE_TYPE)),
                new DisabledEditor(new Application("i"), session, new Path("/p/f", Path.FILE_TYPE))
        );
    }
}
