SUMMARY = "Kwave is a sound editor for KDE"
LICENSE = "GPLv2 & LGPLv2 & CC-BY-SA-3.0 & CC-BY-SA-4.0 & GFDL-1.2 & BSD"
LIC_FILES_CHKSUM = " \
    file://LICENSES;md5=ff723937d3132433003fcf5a792d6e04 \
    file://GNU-LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

inherit kde-apps gtk-icon-cache

DEPENDS += "\
    audiofile \
    fftw \
    libopus \
    libsamplerate0 \
    \
    kcompletion \
    kconfig \
    kconfigwidgets \
    kcoreaddons \
    kcrash \
    kdbusaddons \
    kdoctools \
    ki18n \
    kiconthemes \
    kio \
    kservice \
    ktextwidgets \
    kxmlgui \
    kwidgetsaddons \
"

PV = "${KDE_APP_VERSION}"
SRC_URI += "file://0001-FIND_REQUIRED_PROGRAM-is-broken-use-the-tools-direct.patch"
SRC_URI[md5sum] = "4e4f25a739f04f2fc656be908c499ab8"
SRC_URI[sha256sum] = "11e31e4170e524e82ecb44177c00bac321e73cde3debc97b76f2199fcbafb53f"

# Aagh: To select a soundcard we need to select another type - so keep oss in as dummy
#EXTRA_OECMAKE += "-DWITH_OSS=OFF"

PACKAGECONFIG ??= "alsa mp3"
PACKAGECONFIG[alsa] = "-DWITH_ALSA=ON,-DWITH_ALSA=OFF,alsa-lib"
PACKAGECONFIG[flac] = "-DWITH_FLAC=ON,-DWITH_FLAC=OFF,flac"
PACKAGECONFIG[mp3] = "-DWITH_MP3=ON,-DWITH_MP3=OFF,id3lib libmad"
PACKAGECONFIG[pulseaudio] = "-DWITH_PULSEAUDIO=ON,-DWITH_PULSEAUDIO=OFF,pulseaudio,pulseaudio-server"
PACKAGECONFIG[qtmultimedia] = "-DWITH_QT_AUDIO=ON,-DWITH_QT_AUDIO=OFF,qtmultimedia"

FILES_${PN} += " \
    ${datadir}/kservicetypes5 \
    ${OE_QMAKE_PATH_PLUGINS} \
"
