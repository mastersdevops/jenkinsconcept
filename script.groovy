def buildApp() {
  echo 'building the application...'
  echo 'configuration trigger to pipeline'
}

def testApp() {
  echo 'testing the application...'
}

def deployApp() {
  echo 'deploying the application...'
  echo "deploying version ${params.VERSION}"
}

return this
