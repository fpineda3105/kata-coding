defmodule SquareMoves do

  def vert_mirror(str) do
    str
    |> String.split("\n")
    |> Enum.map(&String.reverse/1)
    |> Enum.join("\n")
  end

  def hor_mirror(str) do
    str
    |> String.split("\n")
    |> Enum.reverse()
    |> Enum.join("\n")
  end

  def oper(func, s) do
    func.(s)
  end

end
