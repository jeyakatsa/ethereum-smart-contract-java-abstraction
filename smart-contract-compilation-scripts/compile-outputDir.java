
static final datatype path = require('path');
static final datatype fs = require('fs-extra');

static final datatype buildPath = path.resolve('ethereum', 'build');

static final datatype createBuildFolder = () => {
    fs.emptyDirSync(buildpath);
        }
