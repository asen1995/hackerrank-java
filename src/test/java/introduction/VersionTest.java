package introduction;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class VersionTest {

    @Test(expected = IllegalArgumentException.class)
    public void nulls() {
        assertNull(new Version(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondVersionMustNotBeNull() {

        Version version = new Version("3.8.0");
        Version versionSnapshot = null;
        version.compareTo(versionSnapshot);
    }
    @Test(expected = IllegalArgumentException.class)
    public void invalidFormatVersion() {
        Version version = new Version("3.8.0-NOTASNAPSHOT");
    }


    @Test
    public void releaseVersionVsSnapshoptVersion() {
        Version version = new Version("3.8.0");
        Version versionSnapshot = new Version("3.8.1-SNAPSHOT");
        Assert.assertTrue(version.compareTo(versionSnapshot) == 1);
    }

    @Test
    public void snapshotVersionVsReleaseVersion() {
        Version version = new Version("3.8.0");
        Version versionSnapshot = new Version("3.8.1-SNAPSHOT");
        Assert.assertTrue(versionSnapshot.compareTo(version) == -1);
    }

    @Test
    public void sameVersions() {
        Version version = new Version("3.8.0");
        Version versionSnapshot = new Version("3.8.0");
        Assert.assertTrue(versionSnapshot.compareTo(version) == 0);
    }

    @Test
    public void firstVersionBiggerThenSecond() {
        Version version = new Version("4.8.0");
        Version versionSecond = new Version("3.8.0");
        Assert.assertTrue(version.compareTo(versionSecond) == 1);
    }


    // expected error messages:

    static final String errorVersionMustNotBeNull = "'version' must not be null!";
    static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";
}

class Version implements Comparable<Version> {

    private final String version;

    public Version(String version) {
        if (version == null) {
            throw new IllegalArgumentException(VersionTest.errorVersionMustNotBeNull);
        }
        if (!version.matches("\\d+\\.\\d+\\.\\d+(-SNAPSHOT)?")) {
            throw new IllegalArgumentException(VersionTest.errorVersionMustMatchPattern);
        }
        this.version = version;
    }

    public int compareTo(Version otherVersion) {
        if (otherVersion == null) {
            throw new IllegalArgumentException(VersionTest.errorOtherMustNotBeNull);
        }

        if(isSnapshot() && !otherVersion.isSnapshot()) {
            return -1;
        }else if (!isSnapshot() && otherVersion.isSnapshot()) {
            return 1;
        }

        String[] myVersion = this.version.split("\\.");
        String[] otherParts = otherVersion.version.split("\\.");

        int length = Math.max(myVersion.length, otherParts.length);
        for (int i = 0; i < length; i++) {
            int thisPart = i < myVersion.length ?
                    Integer.parseInt(myVersion[i]) : 0;
            int otherPart = i < otherParts.length ?
                    Integer.parseInt(otherParts[i]) : 0;
            if (thisPart < otherPart)
                return -1;
            if (thisPart > otherPart)
                return 1;
        }
        return 0;
    }

    public boolean isSnapshot() {
        return this.version.endsWith("-SNAPSHOT");
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Version{" +
                "version='" + version + '\'' +
                '}';
    }

}
