def gv

pipeline {
    agent any
    
    parameters {
        choice(name: 'VERSION', choices:['1.1.0','1.2.0','1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    
    //tools {
        //maven 'Maven'
    //}
    
    environment {
        NEW_VERSION = '1.3.0'
        //SERVER_CREDENTIALS = credentials('MyGitHub')
    }

    stages {
        
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }            
            }
        }
        
        stage("build") {
            steps {
                //echo "building the application..."
                echo "building version ${NEW_VERSION}"
                
                script {
                    gv.buildApp()
                }
                //sh "mvn install"
            }
        }
        
        stage("test") {
            when {
                expression { 
                    //BRANCH_NAME == 'dev'
                    params.executeTests
                }
            }
            steps {
                //echo "testing the application..."
                
                script {
                    gv.testApp()
                }                    
            }
        }
        
        stage("deploy") {
            steps {
                //echo "deploying the application..."                
                //echo "${SERVER_CREDENTIALS}"
                
                withCredentials([
                        usernamePassword(credentialsId: 'MyGitHub', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PWD')
                    ]) {
                        sh "echo $GIT_USER $GIT_PWD"
                    }                                                            
                
                script {
                    gv.deployApp()
                }                                   
            }
        }      
    }
}
