package info.solidsoft.reproducer.groovy.recordlombokgroovy;

import lombok.NonNull;

public record SampleRecordWithNonNullFromLombok(
        @NonNull
        String nonNullField,
        @NonNull        //Two or more @NulNull annotated fields are required to trigger the problem
        String nonNullField2
) {
}
