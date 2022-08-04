package brain;

import java.util.List;
import Mat.*;

public class NeuralNetwork {
    Matrix input_weights, hidden_weights, hidden_bias, output_bias;
    double learning_rate = 0.01;

    public NeuralNetwork(int in_nodes, int hi_nodes, int out_nodes)  {
        input_weights = new Matrix(hi_nodes, in_nodes);
        hidden_weights = new Matrix(out_nodes, hi_nodes);

        hidden_bias = new Matrix(hi_nodes, 1);
        output_bias = new Matrix(out_nodes, 1);
    }

    public List<Double> predict(double[] in_array)  {
        Matrix input = Matrix.fromArray(in_array);
        Matrix hidden = Matrix.multiply(input_weights, input);

        hidden.add(hidden_bias);
        hidden.sigmoid();

        Matrix output = Matrix.multiply(hidden_weights, hidden);
        output.add(output_bias);
        output.sigmoid();

        double temp = output.data[0][0];
        temp *= 10;
        temp = Math.floor(temp);
        int full = 10;
        for (int i = 0; i < temp; i++)  {
            System.out.print("*");
            full--;
        }
        for (int i = 0; i < full; i++)  {
            System.out.print("-");
        }
        System.out.println("");
        return output.toArray();
    }

    public void train(double[] inp_array, double[] target_array)  {
        Matrix input = Matrix.fromArray(inp_array);
        Matrix hidden = Matrix.multiply(input_weights, input);

        hidden.add(hidden_bias);
        hidden.sigmoid();

        Matrix output = Matrix.multiply(hidden_weights, hidden);
        output.add(output_bias);
        output.sigmoid();

        Matrix target = Matrix.fromArray(target_array);

        Matrix error = Matrix.subtract(target, output);
        Matrix gradient = output.dsigmoid();
        gradient.multiply(error);
        gradient.multiply(learning_rate);

        Matrix hidden_t = Matrix.transpose(hidden);
        Matrix hidden_weights_delta = Matrix.multiply(gradient, hidden_t);

        hidden_weights.add(hidden_weights_delta);
        output.add(gradient);

        Matrix hidden_weights_t = Matrix.transpose(hidden_weights);
        Matrix hidden_errors = Matrix.multiply(hidden_weights_t, error);

        Matrix hidden_gradient = hidden.dsigmoid();
        hidden_gradient.multiply(hidden_errors);
        hidden_gradient.multiply(learning_rate);

        Matrix input_t = Matrix.transpose(input);
        Matrix input_weights_delta = Matrix.multiply(hidden_gradient, input_t);

        input_weights.add(input_weights_delta);
        hidden_bias.add(hidden_gradient);
    }

    public void fit (double[][] inp_array, double[][] target_array, int epochs)  {
        for (int i = 0; i < epochs; i++)  {
            int sample = (int) (Math.random() * inp_array.length);
            this.train(inp_array[sample], target_array[sample]);
        }
    }
}