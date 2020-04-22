def container_x(String name, String condition, Closure body) {
    def code = 0
    try {
        code = sh label: 'check container', returnStatus: true, script: condition
    } catch (e) {
        code = -1
    }
    
    if (code == 0) {
        if(body) {
            body()
        }
    } else {
        container(name) {
            if(body) {
                body()
            }
        }
    }
}
