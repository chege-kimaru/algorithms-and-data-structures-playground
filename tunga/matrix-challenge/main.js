function generateMatrix(strArr) {
  const matrix = [];

  let row = [];
  for (const val of strArr) {
    if (val === "<>") {
      matrix.push(row);
      row = [];
    } else {
      row.push(val);
    }
  }
  matrix.push(row);

  return matrix;
}

function cofactor(mat, temp, p, q, n) {
  let i = 0;
  let j = 0;

  for (let row = 0; row < n; row++) {
    for (let col = 0; col < n; col++) {
      if (row != p && col != q) {
        temp[i][j++] = mat[row][col];
        if (j === n - 1) {
          j = 0;
          i++;
        }
      }
    }
  }
}

function determinant(mat, n) {
  let D = 0;

  if (n == 1) return mat[0][0];

  let temp = [];
  for (let i = 0; i < n; i++) {
    let row = [];
    for (let j = 0; j < n; j++) {
      row.push(0);
    }
    temp.push(row);
  }

  let sign = 1;

  for (let f = 0; f < n; f++) {
    cofactor(mat, temp, 0, f, n);
    D += sign * mat[0][f] * determinant(temp, n - 1);

    sign = -sign;
  }

  return D;
}

function MatrixChallenge(strArr) {
  const matrix = generateMatrix(strArr);

  if (matrix.length !== matrix[0].length) return -1;

  return determinant(matrix, matrix.length);
}

// keep this function call here
// ["1","2","4","<>","2","1","1","<>","4","1","1"] expect -4
// ["5","0","<>","0","5"] expect 25
console.log(MatrixChallenge(readline()));
