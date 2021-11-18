defmodule DNATest do
  use ExUnit.Case
  import Dna

  test "should return four T = TTTT when invoked with AAAA" do
    assert Dna.dna_strand("AAAA") == "TTTT"
  end

  test "should return four A = AAAA when invoked with TTTT" do
    assert Dna.dna_strand("TTTT") == "AAAA"
  end

  test "should return  GG  when invoked with CC" do
    assert Dna.dna_strand("CC") == "GG"
  end

  test "should return GCAT when invoked with CGTA" do
    assert Dna.dna_strand("CGTA") == "GCAT"
  end

end
