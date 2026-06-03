pipeline {
agent any

parameters {
    string(name: 'TEST_SUITE', defaultValue: 'smoke')
    string(name: 'ENV', defaultValue: 'qa')
}
stages {
    stage('Checkout Automation Repo') {
        steps {
            checkout scm
        }
    }
    stage('Run Tests') {
        steps {
            echo "Running ${params.TEST_SUITE} tests on ${params.ENV}"
            sh """
            /usr/local/bin/mvn test \
            -Dgroups=${params.TEST_SUITE} \
            -Denv=${params.ENV} \
            -Dbrowser=chrome
            """
        }
    }
    stage('Publish Report') {
        steps {
            echo 'Publishing Extent Report'
        }
    }
}

}