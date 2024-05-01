pipeline {
//  agent any

//  Node name agent
//  agent {
//    node { label "workstation" }
//  }

  agent {
    label "terraform"
  }

//  environment {
//    SAMPLE = "google.com"
//  }

  environment {
    AN_ACCESS_KEY = 'my-predefined-secret-text'
  }

  stages {
    stage("one") {
      steps {
        echo "one"
      }
    }

    stage("two") {
      steps {
        echo "two"
      }
    }
  }

  post {
    always {
      echo 'Hello again!'
    }
  }
}