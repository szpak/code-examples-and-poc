static boolean isExecutedFromIdea() {
    return System.getProperty("java.class.path").contains("idea_rt.jar")
}

unroll {
//    unrollByDefault true  //not needed, enabled by default
//    validateExpressions true  //not needed, enabled by default

//    defaultPattern '#dataVariablesWithIndex'
//    includeFeatureNameForIterations false
    includeFeatureNameForIterations !isExecutedFromIdea()
}
