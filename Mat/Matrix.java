package Mat;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    public int rows;
    public int cols;
    public double[][] data;

    //constructor
    public Matrix (int rows, int cols)  {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];

        //randomize the matrix
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < cols; j++)  {
                data[i][j] = Math.random() * 2 - 1;
            }
        }
    }

    public void displayMatrix()  {
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < cols; j++)  {
                System.out.print("|\t" + data[i][j] + "\t|");
            }
            System.out.print("\n");
        }
    }

    public void add(double num)  {
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < cols; j++)  {
                this.data[i][j] += num;
            }
        }
    }

    public void add(Matrix a) {
        if (cols != a.cols || rows != a.rows)  {
            System.out.print("ADDITION ERROR: rows and cols must match");
            return;
        }
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < cols; j++)  {
                this.data[i][j] += a.data[i][j];
            }
        }
    }

    public static Matrix subtract(Matrix a, Matrix b) {
        Matrix res = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++)  {
            for (int j = 0; j < a.cols; j++)  {
                res.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return res;
    }

    public static Matrix transpose(Matrix a) {
        Matrix res = new Matrix(a.cols, a.rows);
        for (int i = 0; i < a.rows; i++)  {
            for (int j = 0; j < a.cols; j++)  {
                res.data[j][i] = a.data[i][j];
            }
        }
        return res;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        Matrix res=new Matrix(a.rows,b.cols);
        for(int i = 0;i < res.rows;i++) {
            for(int j = 0;j < res.cols;j++) {
                double sum=0;
                for(int k = 0;k < a.cols;k++) {
                    sum += a.data[i][k] * b.data[k][j];
                }
                res.data[i][j] = sum;
            }
        }
        return res;
    }

    public void multiply(Matrix a) {
        for (int i = 0; i < a.rows; i++)  {
            for (int j = 0; j < a.cols; j++)  {
                this.data[i][j] *= a.data[i][j];
            }
        }
    }

    public void multiply (double a) {
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < cols; j++)  {
                this.data[i][j] *= a;
            }
        }
    }

    public void sigmoid()  {
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < cols; j++)  {
                this.data[i][j] = 1 / (1 + Math.exp(-this.data[i][j]));
            }
        }
    }

    public Matrix dsigmoid()  {
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < cols; j++)  {
                res.data[i][j] = this.data[i][j] * (1 - this.data[i][j]);
            }
        }
        return res;
    }

    public static Matrix fromArray(double[] arr)  {
        Matrix res = new Matrix(arr.length, 1);
        for (int i = 0; i < arr.length; i++)  {
            res.data[i][0] = arr[i];
        }
        return res;
    }

    public List<Double> toArray()  {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < cols; j++)  {
                list.add(data[i][j]);
            }
        }
        return list;
    }

}