defmodule SmallSummer do
  def sum_two_smallest_numbers(numbers) do
    numbers
    |> Enum.sort()
    |> Enum.take(2)
    |> Enum.sum()
  end
end
