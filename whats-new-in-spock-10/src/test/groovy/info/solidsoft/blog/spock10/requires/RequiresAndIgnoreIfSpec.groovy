package info.solidsoft.blog.spock10.requires

import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification


class RequiresAndIgnoreIfSpec extends Specification {

    @Requires({ System.getProperty("os.arch") == "i386" })
    def "should use native libraries on 32-bit JVM"() {
        expect:
            true
    }

    @Requires({ env.containsKey("ENABLE_CRM_INTEGRATION_TESTS") })
    def "should do complicated things with CRM"() {
        expect:
            true
    }

    //Run only on Linux and MacOS - in Spock 0.7 style
    @Requires({ System.getProperty("os.name").toLowerCase().contains("mac os") ||
                System.getProperty("os.name").toLowerCase().contains("darwin") ||
                System.getProperty("os.name").toLowerCase().contains("linux")  })
    def "should use fancy text console features - Spock 0.7 style"() {
        expect:
            true
    }

    @Requires({ os.linux || os.macOs  })    //Spock 1.0 edition
    def "should use fancy text console features"() {
        expect:
            true
    }

    @IgnoreIf({ javaVersion < 1.8 })
    def "should find at runtime and use CompletableFuture for Java 8+ - Spock 0.7 style"() {
        expect:
            true
    }

    @IgnoreIf({ !jvm.java8Compatible })
    def "should find at runtime and use CompletableFuture for Java 8+"() {
        expect:
            true
    }
}