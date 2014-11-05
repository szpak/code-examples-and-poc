package stub

import static stub.Constants.CONST1

class GroovyToStub {

    @GroovyAnn(CONST1)  //static import fails on Java stubs generation in joint compilation
    void methodToStub() {
    }

//    //Works fine
//    @GroovyAnn(Constants.CONST1)
//    void methodToStub() {
//    }
}
