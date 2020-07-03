package es.thegoodcode.themoviedb.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import es.thegoodcode.themoviedb.R


class MovieListFragment : Fragment() {

    private var columnCount = 2
    private lateinit var movieAdapter: MyMovieRecyclerViewAdapter
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)

        movieAdapter = MyMovieRecyclerViewAdapter()

        // Set the adapter
        with(recyclerView) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = movieAdapter
        }

        // Observer
        moviesViewModel.popularMovies.observe(viewLifecycleOwner, Observer {
                response -> movieAdapter.setData(response.body()?.results)
                recyclerView.scheduleLayoutAnimation()
        })

        return view
    }

}