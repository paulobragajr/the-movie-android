package br.com.juniorbraga.themovieandroid.model


class MovieSeriesDetail {
    var isAdult: Boolean = false
    var backdrop_path: String? = ""
    var belongs_to_collection: BelongsToCollectionBean? = null
    var budget: Int = 0
    var homepage: String? = null
    var id: Int = 0
    var imdb_id: String? = null
    var original_language: String? = null
    var original_title: String? = null
    var overview: String? = null
    var popularity: Double = 0.toDouble()
    var poster_path: String? = null
    var release_date: String? = null
    var revenue: Int = 0
    var runtime: Int = 0
    var status: String? = null
    var tagline: String? = null
    var title: String? = null
    var isVideo: Boolean = false
    var vote_average: Double = 0.toDouble()
    var vote_count: Int = 0
    var genres: List<GenresBean>? = null
    var production_companies: List<ProductionCompaniesBean>? = null
    var production_countries: List<ProductionCountriesBean>? = null
    var spoken_languages: List<SpokenLanguagesBean>? = null


    // Series
    var created_by: List<CreatedByBean>? = null
    var episode_run_time: List<Int>? = null
    var languages: List<String>? = null
    var networks: List<NetworksBean>? = null
    var origin_country: List<String>? = null
    var seasons: List<SeasonsBean>? = null
    var number_of_episodes: Int = 0
    var number_of_seasons: Int = 0
    var original_name: String? = null
    var type: String? = null
    var last_episode_to_air: LastEpisodeToAirBean? = null
    var name: String? = null
    var next_episode_to_air: NextEpisodeToAirBean? = null
    var isIn_production: Boolean = false
    var first_air_date: String? = null
    var last_air_date: String? = null

    class BelongsToCollectionBean {
        var id: Int = 0
        var name: String? = null
        var poster_path: String? = null
        var backdrop_path: String? = null
    }

    class GenresBean {
        var id: Int = 0
        var name: String? = null
    }

    class ProductionCompaniesBean {
        var id: Int = 0
        var logo_path: String? = null
        var name: String? = null
        var origin_country: String? = null
    }

    class ProductionCountriesBean {
        var iso_3166_1: String? = null
        var name: String? = null
    }

    class SpokenLanguagesBean {
        var iso_639_1: String? = null
        var name: String? = null
    }


    class LastEpisodeToAirBean {
        var air_date: String? = null
        var episode_number: Int = 0
        var id: Int = 0
        var name: String? = null
        var overview: String? = null
        var production_code: String? = null
        var season_number: Int = 0
        var show_id: Int = 0
        var still_path: String? = null
        var vote_average: Int = 0
        var vote_count: Int = 0
    }

    class NextEpisodeToAirBean {
        var air_date: String? = null
        var episode_number: Int = 0
        var id: Int = 0
        var name: String? = null
        var overview: String? = null
        var production_code: String? = null
        var season_number: Int = 0
        var show_id: Int = 0
        var still_path: Any? = null
        var vote_average: Int = 0
        var vote_count: Int = 0
    }


    class CreatedByBean {
        /**
         * id : 88967
         * credit_id : 5256ce3d19c2956ff6082bb1
         * name : Greg Berlanti
         * gender : 2
         * profile_path : /AbocIYSo4KXx7nT6lz2dj3qMD8H.jpg
         */

        var id: Int = 0
        var credit_id: String? = null
        var name: String? = null
        var gender: Int = 0
        var profile_path: String? = null
    }

    class NetworksBean {
        /**
         * name : The CW
         * id : 71
         * logo_path : /ge9hzeaU7nMtQ4PjkFlc68dGAJ9.png
         * origin_country : US
         */

        var name: String? = null
        var id: Int = 0
        var logo_path: String? = null
        var origin_country: String? = null
    }

    class SeasonsBean {
        /**
         * air_date : 2013-10-02
         * episode_count : 8
         * id : 3698
         * name : Specials
         * overview :
         * poster_path : /arpvBHZRhLjDLKGg2ZL8cYMy35I.jpg
         * season_number : 0
         */

        var air_date: String? = null
        var episode_count: Int = 0
        var id: Int = 0
        var name: String? = null
        var overview: String? = null
        var poster_path: String? = null
        var season_number: Int = 0
    }
}