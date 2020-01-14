package org.acme

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingService {
    def greeting(name: String) = s"Hello, ${name}" 
}