const main = (s) => {
  if (s.length % 2 != 0) return false;
  for (let i = 0; i < s.length / 2; i += 2) {
    let j = s.length - 1 - i;

    const condition1 =
      s.charAt(i) === s.charAt(j) && s.charAt(i + 1) === s.charAt(j - 1);
    const condition2 =
      s.charAt(i) === s.charAt(j - 1) && s.charAt(i + 1) === s.charAt(j);

    if (!condition1 && !condition2) return false;
  }
  return true;
};

let test1 = "abba";
let test2 = "baba";
console.log(test1, main(test1));
console.log(test2, main(test2));
