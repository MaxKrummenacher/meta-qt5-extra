SUMMARY = "A library for accessing the usage data collected by the activities system"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = " \
	file://COPYING.LGPL-2;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
	file://COPYING.LGPL-2.1;md5=4fbd65380cdd255951079008b364516c \
	file://COPYING.LGPL-3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

inherit kde-kf5

DEPENDS += " \
    boost \
    kconfig \
    kactivities \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "529ba85f3ff2c78e9b0cbc619ab9a564"
SRC_URI[sha256sum] = "a23955ce584ea0a1be8fe17b0b9cad819279b7518d3a9cf175a40e4bc08fa768"
