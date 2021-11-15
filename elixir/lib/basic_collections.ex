defmodule Collections do
  require Integer

  def double_array(arr) do
    Enum.map(arr, fn(number) -> number * 2 end)
  end

  def filter_odds(n) do
    n
    |> Enum.filter(&Integer.is_odd/1)
  end
end
