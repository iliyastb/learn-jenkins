pipeline {
//  agent any

//  agent {
//    node { label "workstation" }
//  }

  agent {
    label "terraform"
  }

  environment {
    SAMPLE = "google.com"
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