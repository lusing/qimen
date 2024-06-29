const BaZi = require('./bazi.js');
const TianGan = require('./tiangan.js');
const DiZhi = require('./dizhi.js');

const bz = new BaZi(
    TianGan.GENG,
    DiZhi.SHEN,
    TianGan.REN,
    DiZhi.WU,
    TianGan.REN,
    DiZhi.XU,
    TianGan.YI,
    DiZhi.SI,
    true,
    6,
    1980
);

bz.calcWang();
bz.checkDaYun();
