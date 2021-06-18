pipeline {
    agent any
    
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('MyGitHub')
    }

    stages {
        stage("build") {
            steps {
                echo "building the application..."
                echo "building version ${NEW_VERSION}"
            }
        }
        
        stage("test") {
            when {
                expression { 
                    BRANCH_NAME == 'dev'
                }
            }
            steps {
                echo "testing the application..."
            }
        }
        
        stage("deploy") {
            steps {
                echo "deploying the application..."
                echo "${SERVER_CREDENTIALS}"
            }
        }      
    }
}
