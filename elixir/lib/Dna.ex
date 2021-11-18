defmodule Dna do
  def dna_strand(str) do
    String.codepoints(str)
    |> Enum.map(&map_symbol/1)
    |> Enum.join()
  end

  defp map_symbol("A"), do: "T"
  defp map_symbol("T"), do: "A"
  defp map_symbol("G"), do: "C"
  defp map_symbol("C"), do: "G"
end
