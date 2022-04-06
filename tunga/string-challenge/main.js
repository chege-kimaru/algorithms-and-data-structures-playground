function StringChallenge(str) {
  const [pattern, toTest] = str.split(" ");

  let patternIndex = 0;
  let toTestIndex = 0;
  while (patternIndex < pattern.length) {
    const patternChar = pattern.charAt(patternIndex);

    if (patternChar === "+") {
      const toTestChar = toTest.charAt(toTestIndex);

      if (!toTestChar) return false;

      toTestIndex++;
      patternIndex++;
    } else if (patternChar === "*") {
      const nextPatternChar = pattern.charAt(patternIndex + 1);

      if (nextPatternChar === "{") {
        const closingIndex = pattern.indexOf("}", patternIndex + 1);
        const length = +pattern.substring(patternIndex + 2, closingIndex);

        const toTestChar = toTest.charAt(toTestIndex);

        for (let j = 1; j <= length; j++) {
          const currChar = toTest.charAt(toTestIndex);

          if (currChar !== toTestChar) return false;

          toTestIndex++;
        }

        patternIndex += `*{${length}}`.length;
      } else {
        const toTestChar = toTest.charAt(toTestIndex);

        for (let j = 1; j <= 3; j++) {
          const currChar = toTest.charAt(toTestIndex);

          if (currChar !== toTestChar) return false;

          toTestIndex++;
        }

        patternIndex++;
      }
    } else {
      patternIndex++;
    }
  }

  // code goes here
  return toTestIndex === toTest.length;
}

// keep this function call here
// "+++++* abcdemmmmmm"

console.log(StringChallenge("*++* nnnbemmm"));
