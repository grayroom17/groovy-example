package com.groovy.tasks.task2

class Task2 {

    static void main(String[] args) {
        use(IntegerMethods) {
            assert 3.cm + 1.m - 25.mm == 1005
        }

        Integer.metaClass {
            getCm { delegate * 10 }
            getMm { delegate }
            getM { delegate * 1000 }
        }

        assert 3.cm + 1.m - 25.mm == 1005
    }

}
