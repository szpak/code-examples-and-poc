package info.solidsoft.blog.spock10.cleanup.db

class H2DBConnection implements DBConnection {
    @Override
    void close() {
        println "Releasing connection..."
    }
}
