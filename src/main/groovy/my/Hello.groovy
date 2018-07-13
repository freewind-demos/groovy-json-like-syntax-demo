package my

class User {
    String name
    String words

    def play(String sport) {
        println("I like playing $sport")
    }

    @Override
    Object invokeMethod(String name, Object args) {
        println("I can't understand: $name ($args)")
    }
}

def hello(Closure config) {
    def user = new User()
    config.resolveStrategy = Closure.DELEGATE_ONLY
    config.delegate = user
    config.call()
    println(user.name)
    println(user.words)
}

hello {
    setName "Groovy"
    words = "you are groovy"
    play "Football"
    wash "face"
}
