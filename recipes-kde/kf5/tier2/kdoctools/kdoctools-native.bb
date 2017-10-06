require ${BPN}.inc

inherit native cmake_lib

DEPENDS += " \
    libxslt-native \
    libxml2-native \
    karchive-native \
    ki18n-native \
    liburi-perl-native \
    docbook-xml-dtd4-native \
    docbook-xsl-stylesheets-native \
"

SRC_URI += " \
	file://0001-don-t-build-documentation.patch \
"

# make meinproc5 find kdoctools data
CMAKE_ALIGN_SYSROOT[1] = "KF5DocToolsMacros.cmake, -s--stylesheet, -S--srcdir ${STAGING_DATADIR_NATIVE}/kf5/kdoctools --stylesheet"

