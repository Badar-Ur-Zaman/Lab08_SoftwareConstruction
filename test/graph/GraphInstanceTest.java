/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */

abstract class GraphInstanceTest {

    // Abstract method to be implemented by subclasses, returning a new, empty graph instance
    abstract Graph<String> emptyInstance();

    // Test initial vertices in an empty graph
    @Test
    void testInitialVerticesEmpty() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.vertices().isEmpty(), "A new graph should have no vertices.");
    }

    // Test adding a vertex
    @Test
    void testAddVertex() {
        Graph<String> graph = emptyInstance();
        assertTrue(graph.add("A"), "Should return true when adding a new vertex.");
        assertTrue(graph.vertices().contains("A"), "Graph should contain the added vertex.");
    }

    // Test adding duplicate vertices
    @Test
    void testAddDuplicateVertex() {
        Graph<String> graph = emptyInstance();
        graph.add("A");
        assertFalse(graph.add("A"), "Adding a duplicate vertex should return false.");
    }

    // Test adding an edge
    @Test
    void testAddEdge() {
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        assertEquals(0, graph.set("A", "B", 5), "Should return 0 as there was no prior edge.");
        assertTrue(graph.sources("B").containsKey("A"), "Edge should exist from A to B.");
    }

    // Test removing a vertex
    @Test
    void testRemoveVertex() {
        Graph<String> graph = emptyInstance();
        graph.add("A");
        assertTrue(graph.remove("A"), "Removing an existing vertex should return true.");
        assertFalse(graph.vertices().contains("A"), "Graph should not contain the removed vertex.");
    }

    // Test removing a non-existent vertex
    @Test
    void testRemoveNonExistentVertex() {
        Graph<String> graph = emptyInstance();
        assertFalse(graph.remove("A"), "Removing a non-existent vertex should return false.");
    }
}
