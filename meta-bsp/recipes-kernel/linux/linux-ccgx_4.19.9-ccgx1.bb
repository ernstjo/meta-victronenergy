SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

COMPATIBLE_MACHINE = "ccgx"

inherit kernel

LINUX_VERSION_EXTENSION = "-venus"

KERNEL_CONFIG_COMMAND = "oe_runmake -C ${S} O=${B} ccgx_defconfig"
KERNEL_IMAGETYPES = "uImage"
KERNEL_EXTRA_ARGS = "zImage"
KERNEL_DEVICETREE = "am3517-ccgx.dtb"
KEEPUIMAGE = "no"
UBOOT_ENTRYPOINT = "80008000"

# To be compatible with the deployed u-boot, a uImage containing a
# zImage with dtb appended is created.
uboot_prep_kimage() {
	cat arch/${ARCH}/boot/zImage arch/${ARCH}/boot/dts/am3517-ccgx.dtb \
		> linux.bin
        linux_comp=none
}

RDEPENDS_kernel-base = ""

S = "${WORKDIR}/linux-${PV}"
B = "${WORKDIR}/build"

SRC_URI = "https://github.com/victronenergy/linux/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "fec39eab4607531d90e015b0fe1ea5bf"
SRC_URI[sha256sum] = "9dcefc554f1c1561b8a74fdd04847915e6a6f9d00f79f86321d828cdd3fea409"

DEPENDS += "openssl-native"
HOST_EXTRACFLAGS += "-I${STAGING_INCDIR_NATIVE}"
