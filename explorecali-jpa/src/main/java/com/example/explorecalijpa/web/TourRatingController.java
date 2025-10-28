package com.example.explorecalijpa.web;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.example.explorecalijpa.model.TourRating;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.explorecalijpa.business.TourRatingService;

import java.util.NoSuchElementException;

import jakarta.validation.Valid;

/**
 * Tour Rating Controller
 *
 * Created by Mary Ellen Bowman
 */
@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {
  private final TourRatingService tourRatingService;

  public TourRatingController(TourRatingService tourRatingService) {
    this.tourRatingService = tourRatingService;
  }

  /**
   * Create a Tour Rating.
   *
   * @param tourId
   * @param ratingDto
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RatingDto createTourRating(@PathVariable(value = "tourId") int tourId,
      @RequestBody @Valid RatingDto ratingDto) {
    return new RatingDto(tourRatingService.createNew(tourId, ratingDto.getCustomerId(),
      ratingDto.getScore(), ratingDto.getComment()));
  }

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String return404(NoSuchElementException exception) {
    return exception.getMessage();
  }

  @GetMapping
  public List<RatingDto> getRatings(@PathVariable(value = "tourId") int tourId) {
    List<TourRating> tourRatings = tourRatingService.lookupRatings(tourId);
    return tourRatings.stream().map(RatingDto::new).toList();
  }


  @GetMapping("/average")
  public Map<String,Double> getAverage(@PathVariable(value = "tourId") int tourId) {
    return Map.of("average", tourRatingService.getAverageScore(tourId));
  }

  @PutMapping()
  public void updateTourRating(@PathVariable(value = "tourId") int tourId,
                               @RequestBody @Valid RatingDto ratingDto) {
    tourRatingService.update(tourId, ratingDto.getCustomerId(), ratingDto.getScore(), ratingDto.getComment());
  }

  @DeleteMapping("/{customerId}")
  public void deleteTourRating(@PathVariable(value = "tourId") int tourId,
                               @PathVariable(value = "customerId") int customerId) {
    tourRatingService.delete(tourId, customerId);
  }

  /**
   * Update score or comment of a Tour Rating
   *
   * @param tourId
   * @param ratingDto
   * @return The modified Rating DTO.
   */
  @PatchMapping
  public RatingDto updateWithPatch(@PathVariable(value = "tourId") int tourId, @RequestBody @Valid RatingDto ratingDto) {
    return new RatingDto(tourRatingService.updateSome(tourId, ratingDto.getCustomerId(),
      ratingDto.getScore().describeConstable(), ratingDto.getComment().describeConstable()));

  }

}
