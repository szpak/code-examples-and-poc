package info.solidsoft.blog.spock2.migration.talk

import spock.lang.Specification

class UnrollSpec extends Specification {

    def "should calculate number of characters in given animal name"() {
        expect:
            animalName.length() == expectedLength
        where:
            animalName     || expectedLength
            "dog"          || 3
            "wolf"         || 4
            "hippopotamus" || 12
    }


    void "should work without warnings in IDE"() {
        expect:
            fakeCalculateAndAssertMembershipPrice(/*...*/)
        where:
            age ; heigth ; weight ; income ; seniority ;; expectedMembershipPrice
            36  ; 182    ; 82     ; 10000  ; 8         ;; 20
            21  ; 174    ; 67     ; 12000  ; 1         ;; 25
    }

    void "should work without warnings in IDE 2"() {
        expect:
            fakeCalculateAndAssertMembershipPrice(/*...*/)
        where:
            age | heigth | weight | income
            36  | 182    | 82     | 10000
            21  | 174    | 67     | 12000
            _________________________________
            seniority || expectedMembershipPrice
            8         || 20
            1         || 25
    }

    private void fakeCalculateAndAssertMembershipPrice() {
        //fake
    }
}
