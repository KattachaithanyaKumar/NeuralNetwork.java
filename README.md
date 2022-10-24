# NeuralNetwork.java
A java library made in processing (in .pde) made inspired by @Daniel Shiffman(https://github.com/CodingTrain/Toy-Neural-Network-JS) 

note: it is not complete. backpropogation needs to be implemented

## commands

In the Matrix class:
- constructor() : Syntax : new Matrix(rows, cols)
- displayMatrix() : A void function that will print the data in the matrix
- add(double n) : A void function that will perform scalar addition of a number 'n' to the matrix
- add(Matrix m) : A void function that will add a matrix m to the callers matrix
- subtract(Matrix a, Matrix b) : A function that will perform Matrix subtraction between Matrix a and b
- multiply(double n) : A void function that will perform scalar multiplication of a number 'n' to the matrix
- multiply(Matrix b) : A function that returns a matrix after performing multiplication with matrix b with the callers matrix
- multiply(Matrix a, Matrix b) : A function that performs multiplication with matrix a and b
- transpose(Matrix a) : A function that returns a matrix after performing transpose on the callers matrix
- sigmoid() : a function that performs sigmoid on a matrix
- dsigmoid() : a function that performs reverse of sigmoid function

In the NeuralNetwork class:
- constructor(int in, int hi, int out) : initializes the neural network with the number of input, hidden and output nodes
- train(double[] inp_array, double[] target_array) : the train functions trains the model using the inp_array[] and comparing to the target_array[]
- predict(double[] inp_array) : the predict function will predict the result of given inp_array[] after training the model
