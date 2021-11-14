defmodule SumOfOddTriangleLine do
  require Integer

  @spec row_sum_odd_numbers(number) :: number
  def row_sum_odd_numbers(n) do
    n
    |> generate_start_end()
    |> Enum.filter(&Integer.is_odd/1)
    |> Enum.sum()
  end

  defp generate_start_end(1) do 1..1 end
  defp generate_start_end(2) do 3..5 end

  defp generate_start_end(n) do
    start = (n * (n-1)) + 1
    top = (n * n) + (n-1)
    start..top
  end

end
