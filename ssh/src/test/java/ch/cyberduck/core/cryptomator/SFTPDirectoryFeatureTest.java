package ch.cyberduck.core.cryptomator;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.DisabledPasswordCallback;
import ch.cyberduck.core.DisabledPasswordStore;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.cryptomator.features.CryptoFindFeature;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.features.Directory;
import ch.cyberduck.core.sftp.AbstractSFTPTest;
import ch.cyberduck.core.sftp.SFTPDeleteFeature;
import ch.cyberduck.core.sftp.SFTPDirectoryFeature;
import ch.cyberduck.core.sftp.SFTPFindFeature;
import ch.cyberduck.core.sftp.SFTPHomeDirectoryService;
import ch.cyberduck.core.shared.DefaultFindFeature;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.core.vault.DefaultVaultRegistry;
import ch.cyberduck.core.vault.VaultCredentials;

import org.apache.commons.text.RandomStringGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

@RunWith(value = Parameterized.class)
public class SFTPDirectoryFeatureTest extends AbstractSFTPTest {

    @Test
    public void testMakeDirectoryEncrypted() throws Exception {
        final Path home = new SFTPHomeDirectoryService(session).find();
        final Path vault = new Path(home, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        final Path test = new Path(vault, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        final CryptoVault cryptomator = new CryptoVault(vault);
        cryptomator.create(session, null, new VaultCredentials("test"), new DisabledPasswordStore(), vaultVersion);
        session.withRegistry(new DefaultVaultRegistry(new DisabledPasswordStore(), new DisabledPasswordCallback(), cryptomator));
        //        cryptomator.getFeature(session, Directory.class, new SFTPDirectoryFeature(session)).mkdir(test, null, new TransferStatus());
        cryptomator.getFeature(session, Directory.class, new SFTPDirectoryFeature(session)).mkdir(test, null, new TransferStatus());
        assertTrue(new CryptoFindFeature(session, new SFTPFindFeature(session), cryptomator).find(test));
        assertTrue(new CryptoFindFeature(session, new DefaultFindFeature(session), cryptomator).find(test));
//        cryptomator.getFeature(session, Delete.class, new SFTPDeleteFeature(session)).delete(Arrays.asList(test, vault), new DisabledLoginCallback(), new Delete.DisabledCallback());
        cryptomator.getFeature(session, Delete.class, new SFTPDeleteFeature(session)).delete(Arrays.asList(test, vault), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testMakeDirectoryLongFilenameEncrypted() throws Exception {
        assumeTrue(vaultVersion == CryptoVault.VAULT_VERSION_DEPRECATED);
        final Path home = new SFTPHomeDirectoryService(session).find();
        final Path vault = new Path(home, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        final Path test = new Path(vault, new RandomStringGenerator.Builder().build().generate(130), EnumSet.of(Path.Type.directory));
        final CryptoVault cryptomator = new CryptoVault(vault);
        cryptomator.create(session, null, new VaultCredentials("test"), new DisabledPasswordStore(), vaultVersion);
        session.withRegistry(new DefaultVaultRegistry(new DisabledPasswordStore(), new DisabledPasswordCallback(), cryptomator));
        cryptomator.getFeature(session, Directory.class, new SFTPDirectoryFeature(session)).mkdir(test, null, new TransferStatus());
        assertTrue(new CryptoFindFeature(session, new SFTPFindFeature(session), cryptomator).find(test));
        assertTrue(new CryptoFindFeature(session, new DefaultFindFeature(session), cryptomator).find(test));
        cryptomator.getFeature(session, Delete.class, new SFTPDeleteFeature(session)).delete(Arrays.asList(test, vault), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }
}
