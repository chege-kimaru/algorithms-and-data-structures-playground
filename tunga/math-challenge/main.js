function MathChallenge(str) {
  str = str.split(" ").join("");

  const operatorIndex =
    str.indexOf("+") >= 0
      ? str.indexOf("+")
      : null || str.indexOf("-") >= 0
      ? str.indexOf("-")
      : null || str.indexOf("*") >= 0
      ? str.indexOf("*")
      : null || str.indexOf("/") >= 0
      ? str.indexOf("/")
      : null;

  const num1 = str.substring(0, operatorIndex);
  const operator = str.charAt(operatorIndex);
  const num2 = str.substring(operatorIndex + 1, str.indexOf("="));
  const num3 = str.substring(str.indexOf("=") + 1);

  if (num1.indexOf("x") >= 0) {
    if (operator === "+") {
      const a = +num3 - +num2;
      return +String(a).charAt(num1.indexOf("x"));
    } else if (operator === "-") {
      const a = +num3 + +num2;
      return +String(a).charAt(num1.indexOf("x"));
    } else if (operator === "*") {
      const a = +num3 / +num2;
      return +String(a).charAt(num1.indexOf("x"));
    } else if (operator === "/") {
      const a = +num3 * +num2;
      return +String(a).charAt(num1.indexOf("x"));
    }
  } else if (num2.indexOf("x") >= 0) {
    if (operator === "+") {
      const a = +num3 - +num1;
      return +String(a).charAt(num2.indexOf("x"));
    } else if (operator === "-") {
      const a = +num1 - +num3;
      return +String(a).charAt(num2.indexOf("x"));
    } else if (operator === "*") {
      const a = +num3 / +num1;
      return +String(a).charAt(num2.indexOf("x"));
    } else if (operator === "/") {
      const a = +num1 / +num3;
      return +String(a).charAt(num2.indexOf("x"));
    }
  } else if (num3.indexOf("x") >= 0) {
    if (operator === "+") {
      const a = +num1 + +num2;
      return +String(a).charAt(num3.indexOf("x"));
    } else if (operator === "-") {
      const a = +num1 - +num2;
      return +String(a).charAt(num3.indexOf("x"));
    } else if (operator === "*") {
      const a = +num1 * +num2;
      return +String(a).charAt(num3.indexOf("x"));
    } else if (operator === "/") {
      const a = +num1 / +num2;
      return +String(a).charAt(num3.indexOf("x"));
    }
  }

  return 0;
}

// keep this function call here
console.log(MathChallenge(readline()));
