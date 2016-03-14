/*
 * Copyright (c) 2015-2016 Spectra Logic Corporation. All rights reserved.
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
 */

package ch.cyberduck.core.spectra;

import ch.cyberduck.core.features.Attributes;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.s3.S3DisabledMultipartService;
import ch.cyberduck.core.s3.S3WriteFeature;
import ch.cyberduck.core.shared.DefaultAttributesFeature;
import ch.cyberduck.core.shared.DefaultFindFeature;

import org.apache.log4j.Logger;

public class SpectraWriteFeature extends S3WriteFeature {
    private static final Logger log = Logger.getLogger(SpectraWriteFeature.class);

    public SpectraWriteFeature(final SpectraSession session) {
        this(session, new DefaultFindFeature(session), new DefaultAttributesFeature(session));
    }

    public SpectraWriteFeature(final SpectraSession session, final Find finder, final Attributes attributes) {
        super(session, new S3DisabledMultipartService(), finder, attributes);
    }
}
