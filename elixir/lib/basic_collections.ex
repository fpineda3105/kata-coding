defmodule Collections do

  def double_array(arr) do
    Enum.map(arr, fn(number) -> number * 2 end)
  end
end
