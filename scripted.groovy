node("workstation") {
  try {
    stage("one") {
      echo "one"
      sh "exit 1"
    }

    stage("two") {
      echo "two"
    }
  } catch (e) {
    stage ("Declarative: post actions") {
      echo "This will run only if failed"
    }
  }
}