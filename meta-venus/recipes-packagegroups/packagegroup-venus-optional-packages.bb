# build but not installed in the image
inherit packagegroup
LICENSE = "MIT"

DEPENDS += "\
    devmem2 \
    gdb \
    gpsd \
    git \
    lsof \
    nodejs \
    ntp \
    openvpn \
    packagegroup-core-buildessential \
    packagegroup-replace-busybox \
    perf \
    python3-pip \
    python3-pylint \
    python3-spidev \
    s6 \
    tcpdump \
    tinymembench \
    tmux \
    valgrind \
    venus-socketcan-test \
    vim \
    x11vnc \
"

