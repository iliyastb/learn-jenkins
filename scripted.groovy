node("workstation") {
  env.SAMPLE_URL = "google.com"
  try {
    withcredentials([usernamecolonpassword(credentialsId: "ssh", variable: "USERPASS")]) {
      stage("one") {
        echo "one"
        sh "env"
        sh "env >/tmp/env"
      }
    }

    stage("two") {
      echo "two"
      sh "exit 1"
    }
  } catch (e) {
    stage ("Declarative: post actions") {
      echo "This will run only if failed"
    }
  }
}